[
 :module "CljXslLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.0"
 :description "The CljXslLibrary provides a DSL for the programmatic generation of XSL files."
 :plugins ["global"
           ["org.soulspace.baumeister/DependencyPlugin"]
           ["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure" "clojure" "1.5.1"]
                ["org.soulspace.clj" "CljXmlLibrary" "0.2.0"]]
 ]
