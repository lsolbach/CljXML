(defproject org.soulspace.clj/CljSvgLibrary "0.1.3"
  :description "The CljSvgLibrary provides a DSL for the programmatic generation of MathML XML files"
  :url "https://github.com/lsolbach/CljXML"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.apache.xmlgraphics/batik-swing "1.9.1"]
                 [org.apache.xmlgraphics/batik-svggen "1.9.1"]
                 [org.apache.xmlgraphics/batik-svg-dom "1.9.1"]
                 [org.soulspace.clj/CljXmlLibrary "0.4.3"]
                 [org.soulspace.clj/CljJavaLibrary "0.7.0"]]
  :test-paths ["unittest"])
