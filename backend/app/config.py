import os

class Config(object):
    SQLALCHEMY_DATABASE_URI = 'postgres://topaccwikjnjoa:03a967db06a924c7f47d54f165758ab5df910264aec59fe2c9dbf9d550a4f635@ec2-50-17-234-234.compute-1.amazonaws.com:5432/devstm3g31bm8f'
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    LOG_TO_STDOUT = os.environ.get('LOG_TO_STDOUT');
