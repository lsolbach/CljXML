;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.svg.swing
  (:require [org.soulspace.clj.java.beans :as b])
  (:import [org.apache.batik.swing JSVGCanvas JSVGScrollPane]))

; TODO use init-swing from CljSwingLibrary (additional dependency)?
(defn init-svg-swing
  ([c args]
   (b/set-properties! c args)
   c)
  ([c args items]
   (b/set-properties! c args)
   (if (not (nil? items))
     (doseq [item items]
       (if (vector? item)
         (let [[child constraint] item]
           (.add c child constraint))
         (.add c item))))
   c))

(defn svg-canvas [args]
  "Create an SVG canvas."
  (init-svg-swing (JSVGCanvas.) args))

(defn svg-scroll-pane [canvas args]
  "Create an SVG scroll pane."
  (init-svg-swing (JSVGScrollPane. canvas) args))
