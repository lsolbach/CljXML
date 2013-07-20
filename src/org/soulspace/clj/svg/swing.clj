(ns org.soulspace.clj.svg.swing
  (:use [org.soulspace.clj.java beans])
  (:import [org.apache.batik.swing JSVGCanvas JSVGScrollPane]))

; TODO use init-swing from CljSwingLibrary (additional dependency)?
(defn init-svg-swing
  ([c args]
    (set-properties! c args)
    c)
  ([c args items]
    (set-properties! c args)
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
