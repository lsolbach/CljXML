(ns org.soulspace.clj.xml.fo.book-layout
  (:use [clojure.data.xml]
        [org.soulspace.clj.xml xml]
        [org.soulspace.clj.xml.fo.layout])
  (:require [org.soulspace.clj.xml.fo :as fo]))

(defn layout-std-page-body []
  (fo/region-body {:region-name "xsl-region-body" :background-color "blue"}))

(defn layout-title-body []
  (fo/region-body {:region-name "xsl-region-body" :background-color "green"}))

(defn title [element]
  "Titel")

(defn chapters [element]
  "Titel")

(defn book-layout [format]
  (fo/layout-master-set
    {}
    (fo/simple-page-master
      (merge (layout-page-attrs format) (layout-odd-attrs format) (layout-standard-attrs format) {:master-name "title"})
      (layout-title-body))
    (fo/simple-page-master
      (merge (layout-page-attrs format) (layout-odd-attrs format) (layout-standard-attrs format) {:master-name "odd"})
      (layout-std-page-body))
    (fo/simple-page-master
      (merge (layout-page-attrs format) (layout-even-attrs format) (layout-standard-attrs format) {:master-name "even"})
      (layout-std-page-body))
    (fo/page-sequence-master
      {:master-name "chapter"}
      (fo/repeatable-page-master-alternatives
        {}
        (fo/conditional-page-master-reference
          {:master-reference "title" :page-position "first"})
        (fo/conditional-page-master-reference
          {:master-reference "odd" :odd-or-even "odd"})
        (fo/conditional-page-master-reference
          {:master-reference "even" :odd-or-even "even"})))))

; addments/front matter/preliminaries/subsidiaries
(defn layout-addments-chapter-title [chapter]
  (fo/block
    {}
    (title chapter)))

(defn layout-addments [book]
  (fo/page-sequence
    {:master-reference "chapter"}
    (fo/flow
      {:flow-name "xsl-region-body"}
      (fo/block
        {:space-after "20pt"}
        (title book))
      (map layout-addments-chapter-title (chapters book)))))

(defn layout-chapter [chapter]
  (fo/page-sequence
    {:master-reference "chapter"}
    (fo/flow
      {:flow-name "xsl-region-body"}
      (fo/block
        {}
        (title chapter)))))
