import json
from datetime import datetime
from elasticsearch import Elasticsearch
es = Elasticsearch(
    ['elasticsearch']
)

# dateFormat = "yyyy-MM-dd||yyyy-MM-dd'T'HH:mm:ss||basic_date_time_no_millis"
# dateFormat = "yyyy-MM-dd'T'hh:mm:ss"

def createIndex(indexName):
    """Creates index Sets including datatypes that aren't correctly set automatically."""

    mapping = '''
        {
            "mappings":{
                "''' + indexName + '''":{
                    "properties":{
                        "activityEndDate":{
                            "type":"date",
                            "format":"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
                        },
                        "activityStartDate":{
                            "type":"date",
                            "format":"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
                        },
                        "registrationStartDate":{
                            "type":"date",
                            "format":"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
                        }
                    }
                }
            }
        }
    '''

    es.indices.delete(index=indexName, ignore=[400, 404])
    es.indices.create(index=indexName, body=mapping)

createIndex('camp')
createIndex('daycare')
createIndex('activity')

