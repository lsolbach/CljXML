;;
;;   Copyright (c) Ludger Solbach. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file license.txt at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.
;;

(ns org.soulspace.xml.maven.metadata-model
  (:require [clojure.zip :as zip]
            [clojure.data.xml :as xml]
            [clojure.data.zip :as zf]
            [clojure.data.zip.xml :as zx]
            [org.soulspace.xml.maven.metadata-dsl :as md]))

;
; Maven metadata model 1.1.0
;
(defprotocol Metadata
  (metadata-xml [this] "Build XML for metadata."))

(defprotocol MetadataVersioning
  (versioning-xml [this] "Build XML for metadata versioning."))

(defprotocol MetadataSnapshot
  (snapshot-xml [this] "Build XML for metadata snapshot."))

(defprotocol MetadataSnapshotVersion
  (snapshot-version-xml [this] "Build XML for metadata snapshot version."))

(defprotocol MetadataPlugin
    (plugin-xml [this] "Build XML for metadata plugin."))

(defrecord MetadataImpl
  [group-id artifact-id version versioning plugins]
  Metadata
  (metadata-xml [this]
    (md/metadata {}
                 (md/group-id {} group-id)
                 (md/artifact-id {} artifact-id)
                 (when-not (nil? version) (md/version {} version))
                 (versioning-xml versioning))))

(defrecord MetadataVersioningImpl
  [latest release versions snapshot snapshot-versions last-updated]
  MetadataVersioning
  (versioning-xml [this]
    (md/versioning {}
                   (md/latest {} latest)
                   (md/release {} release)
                   (md/versions {} (map md/version versions))
                   (snapshot-xml snapshot)
                   (md/snapshot-versions {} (map md/snapshot-version snapshot-versions))
                   (md/last-updated {} last-updated))))

(defrecord MetadataSnapshotImpl
  [timestamp build-number local-copy]
  MetadataSnapshot
  (snapshot-xml [this]
    (md/snapshot {}
                 (md/timestamp {} timestamp)
                 (md/build-number {} build-number)
                 (md/local-copy {} local-copy))))

(defrecord MetadataSnapshotVersionImpl
  [classifier extension value updated]
  MetadataSnapshotVersion
  (snapshot-version-xml [this]
    (md/snapshot-version {}
                        (md/classifier {} classifier)
                        (md/extension {} extension)
                        (md/value {} value)
                        (md/updated {} updated))))

(defrecord MetadataPluginImpl
  [name prefix artifact-id]
  MetadataPlugin
  (plugin-xml [this]
    (md/plugin {}
               (md/name {} name)
               (md/prefix {} prefix)
               (md/artifact-id {} artifact-id))))

(defn parse-metadata-plugin
  [zipper]
  (when (seq zipper)
    (let [name (zx/xml1-> zipper :name zx/text)
          prefix (zx/xml1-> zipper :prefix zx/text)
          artifact-id (zx/xml1-> zipper :artifactId zx/text)]
      (MetadataPluginImpl. name prefix artifact-id))))

(defn parse-snapshot-version
  [zipper]
  (when (seq zipper)
    (let [classifier(zx/xml1-> zipper :classifier zx/text)
          extension(zx/xml1-> zipper :extension zx/text)
          value(zx/xml1-> zipper :value zx/text)
          updated(zx/xml1-> zipper :updated zx/text)]
     (MetadataSnapshotVersionImpl. classifier extension value updated))))

(defn parse-snapshot
  [zipper]
  (when (seq zipper)
    (let [timestamp (zx/xml1-> zipper :timestamp zx/text)
          build-number (zx/xml1-> zipper :buildNumber zx/text)
          local-copy (zx/xml1-> zipper :localCopy zx/text)]
      (MetadataSnapshotImpl. timestamp build-number local-copy))))

(defn parse-metadata-versioning
  [zipper]
  (when (seq zipper)
    (let [latest (zx/xml1-> zipper :latest zx/text)
          release (zx/xml1-> zipper :release zx/text)
          versions (zx/xml1-> zipper :versions :version zx/text)
          snapshot (parse-snapshot (zx/xml1-> zipper :snapshot))
          snapshot-versions (map parse-snapshot-version (zx/xml1-> zipper :snapshotVersions))
          last-updated (zx/xml1-> zipper :lastUpdated zx/text)]
      (MetadataVersioningImpl. latest release versions snapshot snapshot-versions last-updated))))

(defn parse-metadata
  [zipper]
  (let [group-id (zx/xml1-> zipper :groupId zx/text)
        artifact-id (zx/xml1-> zipper :groupId zx/text)
        version (zx/xml1-> zipper :version zx/text)
        versioning (parse-metadata-versioning (zx/xml1-> zipper :versioning))
        plugins (parse-metadata-plugin (zx/xml1-> zipper :plugins))]
    (MetadataImpl. group-id artifact-id version versioning plugins)))
