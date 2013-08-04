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

(defmacro deftag 
  "Define a function for the given tag that generates the xml representation."
  ([tag]
    (let [xml-fn-name (symbol (fn-name tag))]
      `(defn ~xml-fn-name [& [attrs# & content#]]
         (element (keyword ~tag)
                  (or attrs# {})
                  (remove #(or (nil? %) (empty? %)) content#)))))
  ([ns-prefix tag & [attrs]]
    (let [xml-fn-name (symbol (fn-name tag))]
      `(defn ~xml-fn-name [& [attrs# & content#]]
         (element (keyword (str ~ns-prefix ":" ~tag))
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

