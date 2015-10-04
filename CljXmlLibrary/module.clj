[
 :module "CljXmlLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.4.1"
 :description "The CljXmlLibrary is a library for building XML DSLs in clojure"
 :plugins ["global"
           ["org.soulspace.baumeister/DependencyPlugin"]
           ["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.7.0"]
                ["org.clojure/data.xml, 0.0.7"]
                ["org.soulspace.clj/CljLibrary, 0.6.1"]]
 ]