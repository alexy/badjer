(ns sc)

; print only two decimal digits for the mantissa -- affects ALL doubles!
(defmethod print-method Double [n w] (.write w (.format (java.text.DecimalFormat. "0.0##E0") n)))
; or, for numbers with E only:
(defmethod print-method Double [n w] (let [s (str n)] (.write w (if (re-find #"E" s) (.format (java.text.DecimalFormat. "0.0##E0") n) s))))

(defprotobuf Dailydoubles Dcaps Dailydoubles)

(def dcaps (:dcaps sgraph))
(time (tokyo-pmap-write-reps dcaps "dcaps.clb" Dailydoubles))
(time (tokyo-read-reps "dcaps.clb" Dailydoubles))
