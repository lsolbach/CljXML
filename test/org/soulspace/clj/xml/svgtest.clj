(ns org.soulspace.clj.xml.svgtest
;  (:refer-clojure :exclude [filter set symbol use])
  (:require [org.soulspace.clj.xml.svg :as svg])
  (:use [clojure.data.xml]
        [org.soulspace.clj.xml.svg.graphics2d]))

(defn svg-circles []
  (svg/svg
    {:width "400" :height "400"}
    (svg/circle {:r "100" :cx "200" :cy "200" :style "stroke:black; stroke-width:5; fill:none"})
    (svg/circle {:r "50" :cx "100" :cy "100" :style "stroke:black; fill:green"})))

(defn svg-image []
  (svg/svg
    {:width "300" :height "200"}
    (svg/filter
      {:id "filtereffect1"}
      (svg/feGaussianBlur {:in "SourceAlpha" :stdDeviation "4" :result "img1"})
      (svg/feOffset {:in "img1" :dx "3" :dy "3" :result "img2"})
      (svg/feSpecularLighting {:in "img1" :surfaceScale "4" :specularExponent "10" :result "img3"}
                              (svg/fePointLight {:x "-100" :y "-100" :z "100"}))
      (svg/feComposite {:in "SourceGraphic" :in2 "img3" :operator "arithmetic" :k1 "0" :k2 "1" :k3 "1" :k4 "0" :result "img4"})
      (svg/feMerge {}
                   (svg/feMergeNode {:in "img2"})
                   (svg/feMergeNode {:in "img4"})))
    (svg/g {:style "filter: url(#filtereffect1)"}
           (svg/circle {:r "80" :cx "120" :cy "90" :style "fill: gray"})
           (svg/circle {:r "10" :cx "20" :cy "90" :style "fill: gray"})
           (svg/circle {:r "10" :cx "220" :cy "90" :style "fill: gray"})
           (svg/text {:x "65" :y "75" :style "fill: white; stroke: black; font-family: sans-serif; font-size: 25; font-weight: bold"} "Scalable")
           (svg/text {:x "75" :y "100" :style "fill: white; stroke: black; font-family: sans-serif; font-size: 25; font-weight: bold"} "Vector")
           (svg/text {:x "60" :y "125" :style "fill: white; stroke: black; font-family: sans-serif; font-size: 25; font-weight: bold"} "Graphics"))))

(defn svg-str [f]
  (println (emit-str (f))))
