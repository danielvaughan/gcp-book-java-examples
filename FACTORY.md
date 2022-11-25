# Factory

```shell
export REPO=demo
```

```shell
gcloud services enable sourcerepo.googleapis.com
```

```shell
gcloud source repos create $REPO
```

```shell
gcloud source repos list
```

Note the URL

```shell
git remote add gcp https://source.developers.google.com/p/gcpbook-fact-service/r/demo
```

```shell
git push gcp
```

### Cloud IDE

```shell
export PROJECT=gcpbook-fact-service
```

```shell
gcloud config set project $PROJECT
```

```shell
export REPO=demo
```

```shell
gcloud source repos clone $REPO
```

### Cloud Workstations
 
Clone the project via ssh

Connect the IDE

```shell
gcloud alpha workstations start-tcp-tunnel \
--project=gcp-book-362513 \
--cluster=cluster-ct-london \
--config=config-ct-basic-london-config \
--region=europe-west2 \
ct-basic-london 22 \
--local-host-port=:2222
```
