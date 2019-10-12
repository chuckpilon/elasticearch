#!/usr/bin/env sh

pip install elasticsearch 
cd /data 
python ./elasticsearchCreateIndexes.py
python ./elasticsearchDataSetup.py