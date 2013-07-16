(ns org.soulspace.clj.xml.dsl-builder
  (:require [clojure.string :as str])
  (:use [clojure.data.xml])
  (:import [org.xml.sax InputSource]))

(defn- fn-name [tag]
  "convert to valid function name"
  ; TODO use first-lower or convert camel case
  (.toLowerCase tag)
  ;(str/replace (.toLowerCase tag) \. \-)
  )

(defmacro deftag [ns-prefix tag & [attrs]]
  "define a function for the given tag that generates the xml representation."
  (let [xml-fn-name (symbol (fn-name tag))]
    `(defn ~xml-fn-name [& [attrs# & content#]]
       (element (keyword (str ~ns-prefix ":" ~tag))
                (merge (or ~attrs {}) (or attrs# {}))
                (remove #(or (nil? %) (empty? %)) content#)))))

(defmacro defroottags [ns-prefix ns-uri root-tags]
  "defines functions for the given tags that generate the xml representations per tag including the namespace declaration"
  `(do ~@(map (fn [tag] `(deftag ~ns-prefix ~tag {(keyword (str "xmlns:" ~ns-prefix)) ~ns-uri})) root-tags)))

(defmacro deftags [ns-prefix tags]
  "defines functions for the given tags that generate the xml representation per tag"
  `(do ~@(map (fn [tag] `(deftag ~ns-prefix ~tag)) tags)))

