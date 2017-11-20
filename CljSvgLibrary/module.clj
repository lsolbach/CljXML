[
 :module "CljSvgLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.3"
 :description "The CljSvgLibrary provides a DSL for the programmatic generation of SVG files and wrapper functions for Apache Batik."
 :plugins [["org.soulspace.baumeister/ClojurePlugin"]
           ["org.soulspace.baumeister/ClojureTestPlugin"]
           ["org.soulspace.baumeister/PackagePlugin"]]
 :dependencies [["org.clojure/clojure, 1.8.0"]
                ["org.apache.xmlgraphics/batik-swing, 1.9.1"]
                ["org.apache.xmlgraphics/batik-svggen, 1.9.1"]
                ["org.apache.xmlgraphics/batik-svg-dom, 1.9.1"]
                ["org.soulspace.clj/CljXmlLibrary, 0.4.3"]
                ["org.soulspace.clj/CljJavaLibrary, 0.7.0"]]
 ]