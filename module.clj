[
 :module "CljXsdLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.0"
 :description "The CljXsdLibrary provides a DSL for the programmatic generation of XML Schema files"
 :plugins ["global" "sdeps" "clojure" "package"]
 :dependencies [[["org.clojure" "clojure" "1.5.1"]]
                [["org.clojure" "data.xml" "0.0.7"]]
                [["org.soulspace.clj" "CljXmlLibrary" "0.2.0"]]]
 ]
