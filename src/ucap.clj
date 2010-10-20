(ns sc)

(def ustats (:ustats sgraph))
(time (def ucap (->> ustats (map (fn [[user {:keys [soc]}]] [user soc])) (sort-by second >))))
(def ucapday (map (fn [[user soc]] [user soc (->> user ustats :day)]) ucap))
(def ud20 (->> ucapday (filter #(< (last %) 10)) (take 20)))