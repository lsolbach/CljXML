[
 :module "CljFoLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.0"
 :description "The CljFoLibrary provides a DSL for the generation of XSL Formatting Objects (XSL-FO) files."
 :plugins ["global" "sdeps" "depsdot" "clojure" "package"]
 :dependencies [[["org.clojure" "clojure" "1.5.1"]]
                [["org.soulspace.clj" "CljXmlLibrary" "0.2.0"]]]
 ]