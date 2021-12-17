from Client import *
from Scut import *
import random
import pika
import json
import time

class DataGenerator:
    def __init__(self, clients, scuts):
        self.clients = clients              # list of clients
        self.scuts = scuts                  # list of scuts
        self.credentials = pika.PlainCredentials('user1','user1')
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host= 'localhost', port = '5672', credentials= self.credentials))
        self.channel = self.connection.channel()
        self.channel.queue_declare(queue='portinhas')

    def generatePassage(self):
        client = random.choices(self.clients)[0]
        scut = random.choices(self.scuts)[0]
        #message = {"NEW PASSAGE:   Plate number ": client.get_registration(), "; scut: ":  scut.get_id()}
        #message = {'method': 'NEW_PASSAGE', 'client_registration':client.get_registration(), 'client_deviceId': client.get_deviceId(), 'scut_latitude': scut.get_latitude(), 'scut_longitude': scut.get_longitude(), 'scut_instalationDate': scut.get_instalationDate(), 'scut_priceClass1': scut.get_priceClass1(), 'scut_priceClass2': scut.get_priceClass2(), 'scut_priceClass3': scut.get_priceClass3(), 'scut_priceClass4': scut.get_priceClass4(), 'scut_priceClass5': scut.get_priceClass5()}
        message = {'method': 'NEW_PASSAGE', 'client_deviceId': client.get_deviceId(), 'scut': scut.get_id()}
        self.send("passage", message)

    
    def send(self, topic=None, message=None):
        try:
            message = json.dumps(message)
            print(message)
            self.channel.basic_publish(exchange='', routing_key=topic, body=message)
            print(" [x] Sent 'MESSAGE!'")
        except:
            print("ERROR: Message to broker was not sent")      

def main():


    clients = [Client('AA-00-01', 1000), Client('BB-21-09', 1001), Client('EB-98-11', 1002)]
    scuts = [ Scut(29.8999, 87.9000, 1.23, 1.30, 2.00, 3.90, 2.99), Scut(39.6778, 10.8822, 1.27, 1.45, 2.08, 3.87, 3.02)]


    generator = DataGenerator(clients, scuts)

    while True:
        t = random.randint(0,3)
        time.sleep(t)
        message = generator.generatePassage()


if __name__ == "__main__":
    main()
