export AWS_PROFILE=jc-confidential-majic-development

aws eks update-kubeconfig \
--region us-east-1 \
--name jc-kubernetes-cluster \
--role-arn arn:aws:iam::973959682106:role/K8S-Admin-Role

kubectl config set-context --current --namespace=majic