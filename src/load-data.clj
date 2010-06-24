(load-file "src/tokyo-graph.clj")
(load-file "src/socrun.clj")

(time (def dreps (tokyo-read-reps Repliers "tokyo/dreps.clb")))
(time (def dreps (->> dreps (map (fn [[k v]] [k (into (sorted-map) v)])) (into {}))))
(time (def dments (tokyo-read-reps Repliers "tokyo/dments.clb")))
(time (def dments (->> dments (map (fn [[k v]] [k (into (sorted-map) v)])) (into {}))))
