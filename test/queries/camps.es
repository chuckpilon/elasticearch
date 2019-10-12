GET /camp/_search
{
}

GET /camp/_search
{
    "query": {
        "match": {
            "type": "Overnight"
        }
    }
}

GET /camp/_search
{
    "query": {
        "bool": {
            "must": [
                {
                    "match": {
                        "type": "Overnight"
                    }
                },
                {
                    "range": {
                        "activityStartDate": {
                            "gte": "2019-08-12"
                        }
                    }
                }
            ]
        }
    }
}

GET /camp/_search
{
    "query": {
        "bool": {
            "must": [
                {
                    "range": {
                        "activityStartDate": {
                            "gte": "2019-08-12"
                        }
                    }
                }
            ]
        }
    }
}


GET /camp/_search
{
    "query": {
        "bool": {
            "must": [
                {
                    "activityStartDate": {
                        "eq": "2019-08-12"
                    }
                }
            ]
        }
    }
}


