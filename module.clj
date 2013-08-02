[
 :module "CljDocbookLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.0"
 :description "The CljDocbookLibrary provides a DSL for the programmatic generation of Docbook xml files."
 :plugins ["global" "sdeps" "depsdot" "clojure" "package"]
 :dependencies [[["org.clojure" "clojure" "1.5.1"]]
                [["org.soulspace.clj" "CljXmlLibrary" "0.2.0"]]]
 ]
