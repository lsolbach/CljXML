(ns org.soulspace.clj.xml.marshalling)

(defprotocol XMLMarshalling
  ""
  (to-xml [this] "")
  (from-xml [this xml] "")) ; ? there's no element in the first place, install empty dummy usable as this in record or use a static factory function?

; (defrecord Address
;   [^:attr street ^{:attr true :alias "houseNo"} house-no ^:attr zip ^:attr city country]
;   XMLBinding
;   (to-xml [this] )
;   (from [this element])
;   )
