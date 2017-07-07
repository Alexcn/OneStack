from django.shortcuts import render
from django.views.generic import View
from django.http import HttpResponse, HttpResponseRedirect
from django.utils.decorators import method_decorator
from django.contrib.auth.decorators import login_required
from django.contrib.auth import logout
from django.contrib.auth import authenticate
from django.contrib.auth import login as auth_login
from django.views.decorators.cache import never_cache
from django.views.decorators.csrf import csrf_protect

# Create your views here.


class DashBoardView(View):
    @method_decorator(login_required(login_url='account/login'))
    def get(self, request):
        return render(request, 'account/dashboard.html')


class LoginView(View):
    @method_decorator(csrf_protect)
    @method_decorator(never_cache)
    def post(self, request):
        msg = []
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(username=username, password=password)
        if user is not None:
            if user.is_active:
                auth_login(request, user)
                return HttpResponseRedirect('/')
            else:
                msg.append('Disabled account!')
        else:
            msg.append('Password 错误！')
        return render(request, 'account/login.html', {'errors': msg})

    def get(self, request):
        return render(request, 'account/login.html')


class LogoutView(View):
    def get(self, request):
        pass
