(ns org.soulspace.clj.svg.graphics2d
  (:use [clojure.java.io])
  (:import [java.io StringWriter]
           [java.awt.geom Rectangle2D]
           [org.apache.batik.dom GenericDOMImplementation]
           [org.apache.batik.dom.svg SVGDOMImplementation]
           [org.apache.batik.svggen SVGGraphics2D]))

(defn rectangle-2d [width height]
  (java.awt.geom.Rectangle2D$Double. 0 0 width height))

(defn to-svg [f]
  ; TODO what's the difference between using GenericDOMImplementation or SVGDOMImplementation here?
  ; TODO SVGDOMImplementation seems to have additional dependencies on w3c apis (Parser, ...)
  (let [dom-impl (GenericDOMImplementation/getDOMImplementation)
        document (.createDocument dom-impl "http://www.w3.org/2000/svg" "svg" nil)
        svg-graphics (SVGGraphics2D. document)]
    ; TODO check if still valid in Batik 1.7 (set precision to avoid NPE in Batik 1.5)
    ;(.setPrecision (.getGeneratorContext svg-graphics) 6)
    (f svg-graphics)))

(defn svg-to-writer
  ([writer svg-graphics]
    (svg-to-writer writer svg-graphics true))
  ([writer svg-graphics use-css]
    (with-open [out writer]
      (.stream svg-graphics out use-css))))

(defn svg-to-file
  ([svg-file svg-graphics]
    (svg-to-file svg-file svg-graphics true))
  ([svg-file svg-graphics use-css]
    (svg-to-writer (writer (output-stream svg-file :encoding "UTF-8")) svg-graphics use-css)))

(defn svg-to-string
  ([svg-graphics]
    (svg-to-string svg-graphics true))
  ([svg-graphics use-css]
    (let [writer (StringWriter.)]
      (svg-to-writer writer svg-graphics use-css)
      (.toString writer))))
