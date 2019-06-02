(ns functionl-bank.core
  (:require [org.httpkit.server :refer [run-server]]
            [compojure.core :refer :all]
            [compojure.route :as route]))

(defn index[req]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body {
     "author" "Joao Pedro Poloni Ponce"
     "msg" "Nubank Challenge"
   }
  })

(defn insertOperation [req]
  (println "/transaction")
  (index req))

; Rotas
(defroutes app
  (GET "/" [] "<h1>Ola</h1>")
  (POST "/transaction/:account" [] insertOperation)
  (route/not-found "<h1>Rota nao encontrada</h1>"))

(defn -main [& arg]
  (run-server app {:port 8080})
  (println "Server started on port 8080"))
