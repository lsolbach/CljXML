[
 :module "CljSvgLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.1"
 :description "The CljSvgLibrary provides a DSL for the programmatic generation of SVG files and wrapper functions for Apache Batik."
 :plugins ["global"
           ["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.7.0"]
                ["org.apache.xmlgraphics/batik-swing, 1.7"]
                ["org.apache.xmlgraphics/batik-svggen, 1.7"]
                ["org.soulspace.clj/CljXmlLibrary, 0.4.2"]
                ["org.soulspace.clj/CljJavaLibrary, 0.6.1"]]
 ]