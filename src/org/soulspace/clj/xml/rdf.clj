(ns org.soulspace.clj.xml.rdf
  (:use [org.soulspace.clj.xml xml]))

(deftags "rdf"
  ["about" "aboutEach" "aboutEachPrefix" "bagId" "datatype" "Description" "ID" "li" "nodeID" "parseType" "resource"])

(defroottags "rdf" "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
  ["RDF"])
