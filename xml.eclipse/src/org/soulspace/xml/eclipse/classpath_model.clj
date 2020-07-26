;;
;;   Copyright (c) Ludger Solbach. All rights reserved.
;;   The use and distribution terms for this software are covered by the
;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;   which can be found in the file license.txt at the root of this distribution.
;;   By using this software in any fashion, you are agreeing to be bound by
;;   the terms of this license.
;;   You must not remove this notice, or any other, from this software.
;;

(ns org.soulspace.xml.eclipse.classpath-model
  (:require [clojure.zip :as zip]
            [clojure.data.xml :as xml]
            [clojure.data.zip :as zf]
            [clojure.data.zip.xml :as zx]
            [org.soulspace.xml.marshalling :as m]
            [org.soulspace.xml.zip :as szip]
            [org.soulspace.xml.eclipse.classpath-dsl :as dsl]))

(defrecord Attribute
  [^:attribute name ^:attribute value]
  XMLMarshalling
  (to-xml [this]
    (dsl/attribute
      {:name (:name this) :value (:value this)}))
  XMLUnmarshalling
  (from-xml [_ xml]
    (when xml
      (->Attribute (zx/attr xml :name)
                  (zx/attr xml :value)))))

(defrecord Attributes
  [^:zero-to-many attribute]
  XMLMarshalling
  (to-xml [this]
    (if (seq attribute)
      (dsl/attributes
        {}
        (map to-xml attribute))))
  XMLUnmarshalling
  (from-xml [_ xml]
    (if (seq xml)
      (->Attributes (map (partial from-xml (map->Attribute {})) (zx/xml-> xml :attribute))))))

(defrecord Classpathentry
  [^:attribute kind ^:attribute path ^:optional attributes]
  XMLMarshalling
  (to-xml [this]
    (dsl/classpathentry
      {:kind (:kind this) :path (:path this)}
      (when attributes (to-xml attributes))))
  XMLUnmarshalling
  (from-xml [_ xml]
    (when xml
      (->Classpathentry (zx/attr xml :kind)
                       (zx/attr xml :path)
                       (from-xml (map->Attributes {}) (zx/xml1-> xml :attributes))))))

(defrecord Classpath
  [^:zero-to-many classpathentry]
  XMLMarshalling
  (to-xml [this]
    (dsl/classpath
      {}
      (if (seq classpathentry)
        (map to-xml classpathentry))))
  XMLUnmarshalling
  (from-xml [_ xml]
    (if (seq xml)
      (->Classpath (map (partial from-xml (map->Classpathentry {})) (zx/xml-> xml :classpathentry))))))

;
; unmarshal XML with multi function, which dispatches on the tag keyword
;
(defmulti unmarshal-xml current-zipper-tag)

(defmethod unmarshal-xml :classpath
  [xml]
  (if (seq xml)
    (->Classpath (map unmarshal-xml (zx/xml-> xml :classpathentry)))))

(defmethod unmarshal-xml :classpathentry
  [xml]
  (when xml
    (->Classpathentry (zx/attr xml :kind)
                     (zx/attr xml :path)
                     (unmarshal-xml (zx/xml1-> xml :attributes)))))

(defmethod unmarshal-xml :attributes
  [xml]
  (if (seq xml)
    (->Attributes (map unmarshal-xml (zx/xml-> xml :attribute)))))

(defmethod unmarshal-xml :attribute
  [xml]
  (when xml
      (->Attribute (zx/attr xml :name)
                  (zx/attr xml :value))))

(defmethod unmarshal-xml nil
  [xml])
