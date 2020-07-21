;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.xml.dsl-builder
  (:require [clojure.data.xml :as xml]
            [clojure.string :as str]
            [org.soulspace.clj.string :as sstr]))

(defn- fn-name [tag]
  "Converts tag to valid function name"
  (str/lower-case (sstr/camel-case-to-hyphen tag)))

(defmacro deftag
  "Defines a function for the given tag that generates the xml representation."
  ([tag]
   (let [xml-fn-name (symbol (fn-name tag))]
     `(defn ~xml-fn-name [& [attrs# & content#]]
        (xml/element (keyword ~tag)
                 (or attrs# {})
                 (remove #(or (nil? %) (empty? %)) content#)))))
  ([ns-prefix tag & [attrs]]
   (let [xml-fn-name (symbol (fn-name tag))]
     `(defn ~xml-fn-name [& [attrs# & content#]]
        (xml/element (keyword (str ~ns-prefix ":" ~tag))
                 (merge (or ~attrs {}) (or attrs# {}))
                 (remove #(or (nil? %) (empty? %)) content#))))))

(defmacro deftags
  "Defines functions for the given tags that generate the xml representation per tag"
  ([tags]
   `(do ~@(map (fn [tag] `(deftag ~tag)) tags)))
  ([ns-prefix tags]
   `(do ~@(map (fn [tag] `(deftag ~ns-prefix ~tag)) tags))))

(defmacro defroottags
  "Defines functions for the given tags that generate the xml representations per tag including the namespace declaration"
  [ns-prefix ns-uri root-tags]
  `(do ~@(map (fn [tag] `(deftag ~ns-prefix ~tag {(keyword (str "xmlns:" ~ns-prefix)) ~ns-uri})) root-tags)))
