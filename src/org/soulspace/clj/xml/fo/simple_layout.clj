(ns org.soulspace.clj.xml.fo.simple-layout
  (:use [clojure.data.xml]
        [org.soulspace.clj.xml xml]
        [org.soulspace.clj.xml.fo.layout])
  (:require [org.soulspace.clj.xml.fo :as fo]))

(defn layout-simple-attrs [format]
  {:margin-top (margin format 1)
   :margin-bottom (margin format 1)
   :margin-left (margin format 1)
   :margin-right (margin format 1)})

(defn simple-layout [format]
  (fo/layout-master-set
    {}
    (fo/simple-page-master
      (merge (layout-page-attrs format) (layout-simple-attrs format) {:master-name "title"})
      (fo/region-body {:region-name "xsl-region-body"}))))
