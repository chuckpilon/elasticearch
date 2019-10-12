import json
from elasticsearch import Elasticsearch
es = Elasticsearch(
    ['elasticsearch']
)

def loadData(sourceDoc, indexName, expectedDocs):
    docType = indexName

    with open(sourceDoc) as f:
        data = json.load(f)
    id = 0
    for d in data:
        res = es.index(index=indexName, doc_type=docType, id=id, body=d, op_type='index')
        # print(res['result'])
        id=id+1
    es.indices.refresh(index=indexName)
    
    res = es.search(index=indexName, body={"query": {"match_all": {}}})
    print("Got %d Hits. Expected %d" % (res['hits']['total'], expectedDocs))

    # for hit in res['hits']['hits']:
    #     print("{:20} {:60} {:12}".format(hit["_source"].get("activityStartDate", ""), hit["_source"]["activity"], hit["_source"]["location"]))


loadData('mockdata/CampsData.json', 'camp', 7)
loadData('mockdata/DayCareData.json', 'daycare', 3)
loadData('mockdata/activityData.json', 'activity', 3)
