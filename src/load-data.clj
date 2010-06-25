(load-file "src/tokyo-graph.clj")
(load-file "src/socrun.clj")

(defn load-graph [dreps-name dments-name]
	(let [dreps (tokyo-read-reps Repliers dreps-name)
		  dreps (->> dreps (map (fn [[k v]] [k (into (sorted-map) v)])) (into {}))
		  dments (tokyo-read-reps Repliers dments-name)
		  dments (->> dments (map (fn [[k v]] [k (into (sorted-map) v)])) (into {}))]
	[dreps dments]))
