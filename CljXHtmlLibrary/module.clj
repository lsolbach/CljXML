[
 :module "CljXHtmlLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.2.0"
 :description "The CljXHtmlLibrary provides a DSL for the programmatic generation of XHtml files."
 :plugins ["global"
           ["org.soulspace.baumeister/DependencyPlugin"]
           ["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.5.1"]
                ["org.soulspace.clj/CljXmlLibrary, 0.3.0"]]
 ]
