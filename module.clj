[
 :module "CljSvgLibrary"
 :project "org.soulspace.clj"
 :type :library
 :version "0.1.0"
 :description "The CljSvgLibrary provides a DSL for the programmatic generation of SVG files and wrapper functions for Apache Batik."
 :plugins ["global" "sdeps" "clojure" "package"]
 :dependencies [[["org.clojure" "clojure" "1.5.1"]]
                [["org.clojure" "data.xml" "0.0.7"]]
                [["org.apache.xmlgraphics" "batik-swing" "1.7"]]
                [["org.apache.xmlgraphics" "batik-dom" "1.7"]]
                [["org.apache.xmlgraphics" "batik-svg-dom" "1.7"]]
                [["org.apache.xmlgraphics" "batik-svggen" "1.7"]]
                [["org.apache.xmlgraphics" "batik-ext" "1.7"]]
                [["org.apache.xmlgraphics" "batik-xml" "1.7"]]
                [["org.apache.xmlgraphics" "batik-css" "1.7"]]
                [["org.apache.xmlgraphics" "batik-parser" "1.7"]]
                [["org.apache.xmlgraphics" "batik-anim" "1.7"]]
                [["org.apache.xmlgraphics" "batik-gvt" "1.7"]]
                [["org.apache.xmlgraphics" "batik-bridge" "1.7"]]
                [["org.apache.xmlgraphics" "batik-script" "1.7"]]
                [["org.apache.xmlgraphics" "batik-js" "1.7"]]
                [["org.apache.xmlgraphics" "batik-util" "1.7"]]
                [["org.apache.xmlgraphics" "batik-awt-util" "1.7"]]
                [["org.apache.xmlgraphics" "batik-gui-util" "1.7"]]
                [["xalan" "xalan" "2.7.1"]] ; transitive batik
                [["xalan" "serializer" "2.7.1"]] ; transitive batik
                [["xerces" "xercesImpl" "2.9.0"]] ; transitive batik
                [["xml-apis" "xml-apis" "1.3.04"]] ; transitive batik
                [["xml-apis" "xml-apis-ext" "1.3.04"]] ; transitive batik
                [["org.soulspace.clj" "CljXmlLibrary" "0.2.0"]] ; TARGET DEV!
                [["org.soulspace.clj" "CljJavaLibrary" "0.2.0"]]
                [["org.soulspace.clj" "CljLibrary" "0.3.0"]] ; transitive CljJavaLibrary
                ]
 ]