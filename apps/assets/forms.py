from django import forms
from .models import HardwareAsset


class HardwareAssetForm(forms.ModelForm):
    class Meta:
        model = HardwareAsset
        fields = [
            'name', 'ip_set', 'management_port', 'mac_address_set',
            'description', 'has_activated'
        ]
