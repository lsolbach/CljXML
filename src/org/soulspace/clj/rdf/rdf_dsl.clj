(ns org.soulspace.clj.rdf.rdf-dsl
  (:use [org.soulspace.clj.xml dsl-builder]))

(deftags "rdf"
  ["about" "aboutEach" "aboutEachPrefix" "bagId" "datatype" "Description" "ID" "li" "nodeID" "parseType" "resource"])

(defroottags "rdf" "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
  ["RDF"])
