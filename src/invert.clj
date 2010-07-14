(defn invert-graph [reps]
(reduce 
  (fn [inv [from reps]] 
    (reduce (fn [inv [to dates]] (update-in inv [to from] #(into (or % []) dates))) inv reps)) 
    {} reps))


;; (time (do (def dreps (->> (tokyo (map (fn [[k v]] [k (into (sorted-map) v)])) (into {})))
;; ))

;; (time (def dments (invert-graph dreps)))
;; (time (tokyo-agents-write-reps dments "dments.clb"))