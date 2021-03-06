;;
;;   Copyright (c) Ludger Solbach. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file license.txt at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.
;;

(ns org.soulspace.xml.maven.metadata-dsl
  (:refer-clojure :exclude [filter name type])
  (:require [org.soulspace.xml.dsl-builder :as dsl]))

;;
;; DSL for the Maven metadata model 1.1.0
;;
(dsl/deftags "md" ["artifactId" "buildNumber" "classifier" "extension" "groupId" "lastUpdated" "latest"
                   "localCopy" "name" "plugin" "plugins" "prefix" "release" "snapshot" "snapshotVersion"
                   "snapshotVersions" "timestamp" "updated" "value" "version" "versioning" "versions"])

(dsl/defroottags "md" "http://maven.apache.org/METADATA/1.1.0" ["metadata"])

