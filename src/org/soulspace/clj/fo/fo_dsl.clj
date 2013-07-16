(ns org.soulspace.clj.fo.fo-dsl
  (:refer-clojure :exclude [float])
  (:use [org.soulspace.clj.xml dsl-builder]))

(deftags "fo"
  ["basic-link" "block" "block-container" "character" "color-profile"
   "conditional-page-master-reference"
   "declarations" "external-graphics" "float" "flow" "inline"
   "instream-foreign-object" "layout-master-set" "leader" "list-block"
   "list-item" "list-item-body" "list-item-label" "marker" "page-number"
   "page-number-citation" "page-sequence" "page-sequence-master"
   "page-sequences" "region-after" "region-before" "region-body"
   "region-end" "region-start" "repeatable-page-master-alternatives"
   "repeatable-page-master-reference" "retrieve-marker"
   "simple-page-master" "single-page-master-reference" "static-content"
   "table" "table-and-caption" "table-body" "table-cell" "table-column"
   "table-footer" "table-header" "table-row" "title" "wrapper"])

(defroottags "fo" "http://www.w3.org/1999/XSL/Format" ["root"])
