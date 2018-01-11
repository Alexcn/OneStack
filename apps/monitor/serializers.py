from rest_framework import serializers
from .models import ServerInfoCollection


class ServerInfoCollectionSerializer(serializers.Serializer):
    id = serializers.IntegerField(read_only=True)

    def create(self, validated_data):
        pass

    def update(self, instance, validated_data):
        pass
