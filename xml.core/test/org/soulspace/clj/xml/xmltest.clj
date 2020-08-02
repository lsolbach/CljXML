(ns org.soulspace.xml.xmltest
  (:use [clojure.data xml]
        [clojure.string :only [join]]))

(defn ns-xml []
  (element :fo:root {:xmlns:fo "http://www.w3.org/1999/XSL/Format"}))

(defn fo-root [& [attrs & content]]
  (element (keyword (str "fo" ":" "root")) (or attrs {}) (remove nil? content)))

(defn fo-layout-master-set [& [attrs & content]]
  (element (keyword (str "fo" ":" "layout-master-set")) (or attrs {}) (remove nil? content)))

(defn fo-simple-page-master [& [attrs & content]]
  (element (keyword (str "fo" ":" "simple-page-master")) (or attrs {}) (remove nil? content)))


(println (emit-str (ns-xml)))
(println (indent-str (ns-xml)))

(println "fo:root"
         (indent-str
           (fo-root
             {:xmlns:fo "http://www.w3.org/1999/XSL/Format"}
             (fo-layout-master-set {}
               (fo-simple-page-master
                 {:master-name "single" :page-height "297mm" :page-width "210mm"})))))
