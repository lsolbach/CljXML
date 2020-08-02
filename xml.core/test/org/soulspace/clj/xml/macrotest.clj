(ns org.soulspace.xml.macrotest
  (:use [org.soulspace.xml marshalling zip])
  (:require [clojure.zip :as zip]
            [clojure.data.xml :as xml]))

(defmacro metatest [v]
  (doseq [entry v]
    (println "Element:")
    (println entry (meta entry))
    (when (:attributes entry)
      (doseq [a (:attributes entry)]
        (println "  Attribute")
        (println "  " a (meta a))))
    (when (:content entry)
      (doseq [c (:content entry)]
        (println "  Content")
        (println "  " c (meta c))))))

; hierarchical map
(def hierarchical-spec
 ^{:ns "http://eclipse.org/classpath"}
  ^{:ns-prefix "cp"}
  {:element "Classpath"
   :content
   [^:optional
    ^:many
    {:element "Classpathentry"
     :attributes ["kind" "path"]
     :content
     [^:optional
      {:element "Attributes"
       :content
       [^:optional
        ^:many
        {:element "Attribute"
         :attributes ["name" "value"]}]}]}]})


; flat vector of  maps
(def flat-spec
  ^{:ns-prefix "cp"}
  '[
    ^:root
    ^{:ns "http://eclipse.org/classpath"}
    {:element Classpath
     :content
     [^:optional
      ^:many
      Classpathentry]}

    {:element Classpathentry
     :attributes ["kind" "path"]
     :content
     [^:optional
      Attributes]}

    {:element Attributes
     :content
     [^:optional
      ^:many
      Attribute]}

    {:element Attribute
     :attributes ["name" "value"]}])


(metatest ^{:ns-prefix "cp"}
  [
   ^:root
   ^{:ns "http://eclipse.org/classpath"}
   {:element Classpath
    :content
    [^:optional
     ^:many
     Classpathentry]}

   {:element Classpathentry
    :attributes ["kind" "path"]
    :content
    [^:optional
     Attributes]}

   {:element Attributes
    :content
    [^:optional
     ^:many
     Attribute]}

   {:element Attribute
    :attributes ["name" "value"]}])
