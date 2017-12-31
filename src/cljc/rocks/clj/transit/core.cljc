(ns rocks.clj.transit.core
  (:require [cognitect.transit :as t]
            #?(:clj [clojure.java.io :as io])))

(defn to-transit
  "Serialization for clojure data."
  [msg]
  #?(:clj (let [out (java.io.ByteArrayOutputStream. 4096)
                writer (t/writer out :json)]
            (t/write writer msg)
            (str out))
     :cljs (let [writer (t/writer :json)]
             (t/write writer msg))))

(defn from-transit
  "Deserialization for clojure data."
  [in]
  #?(:clj (let [stream (io/input-stream (.getBytes in))
                reader (t/reader stream :json)]
            (t/read reader))
     :cljs (let [reader (t/reader :json)]
             (t/read reader in))))
