from django import forms


class WikiForm(forms.Form):
    title = forms.CharField(max_length=254)
    status = forms.ChoiceField(('draft', 'published'))
    content = forms.CharField(widget=forms.Textarea, required=False)
