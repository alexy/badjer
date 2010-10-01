;; user=> g
;; {:a {1 {:b 1, :c 2}, 2 {:b 2, :d 1}}, :b {2 {:a 2, :e 3}, 3 {:a 1, :c 1}}, :c {1 {:a 2, :b 3, :d 1}, 2 {:a 1, :b 2, :d 3}}}
;; user=> (->> (for [[from m] g [day tons] m [to n] tons] [to day from n]) (reduce (fn [res [to day from n]] (assoc! res to (let [days (res to (sorted-map)) day-reps (days day {}) n-old (day-reps from 0)] (assoc days day (assoc day-reps from (+ n-old n)))))) (transient {})) persistent!)
;; {:b {1 {:c 3, :a 1}, 2 {:c 2, :a 2}}, :c {1 {:a 2}, 3 {:b 1}}, :d {1 {:c 1}, 2 {:c 3, :a 1}}, :a {1 {:c 2}, 2 {:c 1, :b 2}, 3 {:b 1}}, :e {2 {:b 3}}}

(defn invert-graph [g]
  (->> (for [[from m] g [day tons] m [to n] tons] [to day from n])
       (reduce (fn [res [to day from n]]
         (assoc! res to (let [days     (res to (sorted-map))
                              day-reps (days day {})]
                           (assoc days day
                                       (assoc day-reps from n)))))
         (transient {}))
       persistent!))


;; (load-file "src/tokyo-graph.clj")
;; (time (do (def dreps (->> (tokyo-read-reps "t/dreps.clb") (map (fn [[k v]] [k (into (sorted-map) v)])) (into {})))))
;; (load-file "src/invert.clj")
;; (time (def dments (invert-graph dreps)))
;; (time (tokyo-agents-write-reps dments "dments.clb"))