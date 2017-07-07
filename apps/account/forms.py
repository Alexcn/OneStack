from django import forms


class LoginForm(forms.Form):
    username = forms.CharField(max_length=255, widget=forms.TextInput(attrs={'class': 'form-control',
                                                                             'placeholder': '用户名',
                                                                             'required': 'required'}))
    password = forms.CharField(widget=forms.PasswordInput(attrs={'class': 'form-control',
                                                                 'placeholder': '密 码', 'required': 'required'}))
    error_messages = {
        'invalid_login': ("Please enter a correct %(username)s and password. "
                          "Note that both fields may be case-sensitive."),
        'inactive': ("This account is inactive."),
    }
