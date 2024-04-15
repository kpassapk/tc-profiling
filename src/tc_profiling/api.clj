(ns tc-profiling.api
  (:require [tablecloth.api :as tc]
            [tech.v3.dataset :as ds]
            [rum.core :as rum]
            [scicloj.kindly.v4.api :as kindly]
            [scicloj.kindly.v4.kind :as kind]))

^:kindly/hide-code
(def html
  (comp kindly/hide-code kind/html rum/render-static-markup))

;; From Tablecloth
(defn- columns-info
  [ds]
  (tc/dataset (->> (ds/columns ds)
                (map meta))
           {:dataset-name (str (ds/dataset-name ds) " :column info")}))

(defn- profile
  [ds]
  (ds/descriptive-stats ds))

;; From Tablecloth
(defn info
  "Returns a statistcial information about the columns of a dataset.
  `result-type ` can be :descriptive or :columns"
  ([ds] (info ds :descriptive))
  ([ds result-type]
   (condp = result-type
     :descriptive (ds/descriptive-stats ds)
     :columns (columns-info ds)
     :profile (profile ds)
     (let [grouped? (boolean (:grouped? (meta ds)))
           nm (ds/dataset-name ds)
           inf {:name nm
                :grouped? grouped?}]
       (tc/dataset (if grouped?
                  (assoc inf :groups (ds/row-count inf))
                  (assoc inf
                         :rows (ds/row-count ds)
                         :columns (ds/column-count ds)))
                {:dataset-name (str nm " :basic info")})))))
