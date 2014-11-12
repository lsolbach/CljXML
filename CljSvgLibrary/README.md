CljSvgLibrary
=============
The CljSvgLibrary provides a DSL for the programmatic generation of SVG files and wrapper functions for Apache Batik.

Documentation
-------------
Example:

```
(emit-str
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
```

Running the code above yields the following SVG (formatted here for better readability).
```
<?xml version="1.0" encoding="UTF-8"?>
<svg:svg height="200" width="300" xmlns:svg="http://www.w3.org/2000/svg">
	<svg:filter id="filtereffect1">
		<svg:feGaussianBlur stdDeviation="4" result="img1" in="SourceAlpha"></svg:feGaussianBlur>
		<svg:feOffset result="img2" dy="3" dx="3" in="img1"></svg:feOffset>
		<svg:feSpecularLighting surfaceScale="4" result="img3" specularExponent="10" in="img1">
			<svg:fePointLight x="-100" y="-100" z="100"></svg:fePointLight>
		</svg:feSpecularLighting>
		<svg:feComposite operator="arithmetic" k2="1" k1="0" result="img4" k3="1" k4="0" in2="img3" in="SourceGraphic"></svg:feComposite>
		<svg:feMerge>
			<svg:feMergeNode in="img2"></svg:feMergeNode>
			<svg:feMergeNode in="img4"></svg:feMergeNode>
		</svg:feMerge>
	</svg:filter>
	<svg:g style="filter: url(#filtereffect1)">
		<svg:circle cx="120" cy="90" style="fill: gray" r="80"></svg:circle>
		<svg:circle cx="20" cy="90" style="fill: gray" r="10"></svg:circle>
		<svg:circle cx="220" cy="90" style="fill: gray" r="10"></svg:circle>
		<svg:text style="fill: white; stroke: black; font-family: sans-serif; font-size: 25; font-weight: bold" x="65" y="75">Scalable</svg:text>
		<svg:text style="fill: white; stroke: black; font-family: sans-serif; font-size: 25; font-weight: bold" x="75" y="100">Vector</svg:text>
		<svg:text style="fill: white; stroke: black; font-family: sans-serif; font-size: 25; font-weight: bold" x="60" y="125">Graphics</svg:text>
	</svg:g>
</svg:svg>
```

Author/Project Lead
-------------------
Ludger Solbach

Copyright
---------
© 2011-2013 Ludger Solbach

License
-------
[Eclipse Public License 1.0] (http://www.eclipse.org/legal/epl-v10.html "EPL 1.0")

Code Repository
---------------
[https://github.com/lsolbach/CljJavaLibrary] (https://github.com/lsolbach/CljJavaLibrary)

History
-------

Version 0.1.0 (--.--.2013)
--------------------------
* Initial import
* Initial git import
