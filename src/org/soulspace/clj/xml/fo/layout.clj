(ns org.soulspace.clj.xml.fo.layout)

(def units-keys [:mm :cm :in :pt :px :em])

(def formats-keys [:a0-portrait :a0-landscape :a1-portrait :a1-landscape :a2-portrait :a2-landscape :a3-portrait :a3-landscape
                      :a4-portrait :a4-landscape :a5-portrait :a5-landscape :a6-portrait :a6-landscape :a7-portrait :a7-landscape
                      :us-letter-portrait :us-letter-landscape :us-legal-portrait :us-legal-landscape :business-card])

(def format-definitions
  {:a0-portrait {:page-height 2376 :page-width 1680 :margin-base 160 :unit :mm}
   :a0-landscape {:page-height 1680 :page-width 2376 :margin-base 160 :unit :mm}
   :a1-portrait {:page-height 1188 :page-width 840 :margin-base 80 :unit :mm}
   :a1-landscape {:page-height 840 :page-width 1188 :margin-base 80 :unit :mm}
   :a2-portrait {:page-height 594 :page-width 420 :margin-base 40 :unit :mm}
   :a2-landscape {:page-height 420 :page-width 594 :margin-base 40 :unit :mm}
   :a3-portrait {:page-height 420 :page-width 297 :margin-base 20 :unit :mm}
   :a3-landscape {:page-height 297 :page-width 420 :margin-base 20 :unit :mm}
   :a4-portrait {:page-height 297 :page-width 210 :margin-base 10 :unit :mm}
   :a4-landscape {:page-height 210 :page-width 297 :margin-base 10 :unit :mm}
   :a5-portrait {:page-height 210 :page-width 148 :margin-base 5 :unit :mm}
   :a5-landscape {:page-height 148 :page-width 210 :margin-base 5 :unit :mm}
   :a6-portrait {:page-height 148 :page-width 105 :margin-base 2.5 :unit :mm}
   :a6-landscape {:page-height 105 :page-width 148 :margin-base 2.5 :unit :mm}
   :a7-portrait {:page-height 105 :page-width 74 :margin-base 2.5 :unit :mm}
   :a7-landscape {:page-height 74 :page-width 105 :margin-base 2.5 :unit :mm}
   :us-letter-portrait {:page-height 11 :page-width 8.5 :margin-base 1 :unit :in} ; FIXME set useful margin
   :us-letter-landscape {:page-height 8.5 :page-width 11 :margin-base 1 :unit :in} ; FIXME set useful margin
   :us-legal-portrait {:page-height 14 :page-width 8.5 :margin-base 1 :unit :in} ; FIXME set useful margin
   :us-legal-landscape {:page-height 8.5 :page-width 14 :margin-base 1 :unit :in} ; FIXME set useful margin
   :business-card {:page-height 54 :page-width 85.6 :margin-base 1 :unit :mm} ; FIXME set useful margin
   })

(defn margin [format factor]
  (str (* factor (:margin-base format)) (name (:unit format))))

(defn layout-page-attrs [format]
  {:page-height (str (:page-height format) (name (:unit format)))
   :page-width (str (:page-width format) (name (:unit format)))})

(defn layout-odd-attrs [format]
  {:margin-left (margin format 2)
   :margin-right (margin format 4)})

(defn layout-even-attrs [format]
  {:margin-left (margin format 4)
   :margin-right (margin format 2)})

(defn layout-standard-attrs [format]
  {:margin-top (margin format 3) :margin-bottom (margin format 6)})
