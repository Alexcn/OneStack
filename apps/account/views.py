from django.shortcuts import render, render_to_response
from django.views.generic import View
from django.http import HttpResponse, HttpResponseRedirect, HttpResponsePermanentRedirect
from django.utils.decorators import method_decorator
from django.contrib.auth.decorators import login_required
from django.contrib.auth import logout
from django.core.urlresolvers import reverse
from django.contrib.auth import authenticate
from django.contrib.auth import login as auth_login
from django.views.decorators.cache import never_cache
from django.views.decorators.csrf import csrf_protect
from apps.common.utils import LoginRequiredMixin

# Create your views here.


class DashBoardView(LoginRequiredMixin, View):
    def get(self, request):
        return render(request, 'account/dashboard.html')
        # return render_to_response('account/dashboard.html')


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


class LogoutView(LoginRequiredMixin, View):
    def get(self, request):
        logout(request)
        return HttpResponsePermanentRedirect(reverse('account:login'))

