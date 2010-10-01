(load-file "src/tokyo-graph.clj")
(load-file "src/socrun.clj")
(load-file "src/invert.clj")


(defn load-graph [dreps-name]
  "load one graph"
  (let [dreps (tokyo-read-reps dreps-name)]
		    (->> dreps (map (fn [[k v]] [k (into (sorted-map) v)])) (into {}))))

(defn load-graphs [dreps-name & [dments-name]]
	(let [dreps  (load-graph dreps-name)
	  	  dments (if dments-name (load-graph dments-name)
	  	                         (invert-graph dreps))]
	[dreps dments]))
