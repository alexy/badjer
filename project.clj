(defproject badger "1.0"
  :description "Karmic Social Capital in Clojure"
  :dependencies [
    [clojure "1.2.0"]
    [clojure-contrib "1.2.0"]
    [joda-time "1.6"]
    [cupboard "1.0-SNAPSHOT"]
    [net.1978th/tokyocabinet "1.23"]
    [clojure-protobuf "0.2.11-SNAPSHOT"]
    [jiraph "0.1.3-SNAPSHOT"]
    [clj-json/clj-json "0.3.0-SNAPSHOT"]]
    :dev-dependencies [[clojure-protobuf "0.2.11-SNAPSHOT"]]
    :tasks [protobuf.tasks]
  )
